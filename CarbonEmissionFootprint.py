import os
import base64
import google.auth
from google.auth.transport.requests import Request
from google.oauth2.credentials import Credentials
from googleapiclient.discovery import build
from googleapiclient.errors import HttpError
import requests
from google_auth_oauthlib.flow import InstalledAppFlow

def getGmailConnection():
    credentials = None
    authorizationFilePath = 'authorization.json'

    if os.path.exists(authorizationFilePath):
        credentials = Credentials.from_authorized_user_file(authorizationFilePath)

    if not credentials or not credentials.valid:
        if credentials and credentials.expired and credentials.refresh_token:
            credentials.refresh(Request())
        else:
            secretFile = InstalledAppFlow.from_client_secrets_file(
              'credentials.json', ['https://www.googleapis.com/auth/gmail.readonly']
          )

            credentials = secretFile.run_local_server(port=0)

        with open(authorizationFilePath, 'w') as authorizationFile:
          authorizationFile.write(credentials.to_json())

    return build('gmail', 'v1', credentials=credentials)

def getEmailCount(service, userId, labelId):
    try:
        response = service.users().labels().get(userId=userId, id=labelId).execute()
        return response['messagesTotal']
    except HttpError as e:
        print(f"Error getting email count: {e}")
        return 0
      
def getCarbonEmission(email_count):
    emission_per_email = 0.3
    total_emission = email_count * emission_per_email
    return total_emission


def main():
  gmailConnection = getGmailConnection()
  userId = 'lk356003@gmail.com'

  inboxCount = getEmailCount(gmailConnection, userId, 'INBOX')
  sentCount = getEmailCount(gmailConnection, userId, 'SENT')
  spamCount = getEmailCount(gmailConnection, userId, 'SPAM')

  print(f'Inbox count: {inboxCount}')
  print(f'Sent count: {sentCount}')
  print(f'Spam count: {spamCount}')

  totalEmails = inboxCount + sentCount + spamCount
  totalEmission = getCarbonEmission(totalEmails)
  print(f'Estimated carbon emission for emails: {totalEmission} kilograms of CO2')


if __name__ == '__main__':
  main()
