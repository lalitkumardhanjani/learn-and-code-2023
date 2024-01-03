import os
from googleapiclient.discovery import build
from googleapiclient.errors import HttpError
from google.oauth2.credentials import Credentials
from google_auth_oauthlib.flow import InstalledAppFlow

def load_credentials(authorization_file_path='authorization.json'):
    credentials = None

    if os.path.exists(authorization_file_path):
        credentials = Credentials.from_authorized_user_file(authorization_file_path)

    if not credentials or not credentials.valid:
        credentials = refresh_credentials(credentials)

        save_credentials(credentials, authorization_file_path)

    return credentials

def refresh_credentials(credentials):
    if credentials and credentials.expired and credentials.refresh_token:
        credentials.refresh(Request())
    else:
        credentials = request_new_credentials()

    return credentials

def request_new_credentials(secret_file_path='credentials.json'):
    secret_file = InstalledAppFlow.from_client_secrets_file(
        secret_file_path, ['https://www.googleapis.com/auth/gmail.readonly']
    )

    return secret_file.run_local_server(port=0)

def save_credentials(credentials, authorization_file_path='authorization.json'):
    with open(authorization_file_path, 'w') as authorization_file:
        authorization_file.write(credentials.to_json())

def get_gmail_connection(credentials):
    return build('gmail', 'v1', credentials=credentials)

def get_email_count(service, user_id, label_id):
    try:
        response = service.users().labels().get(userId=user_id, id=label_id).execute()
        return response['messagesTotal']
    except HttpError as e:
        print(f"Error getting email count: {e}")
        return 0

def get_carbon_emission(email_count):
    emission_per_email = 0.3
    return email_count * emission_per_email

def main():
    authorization_file_path = 'authorization.json'
    credentials = load_credentials(authorization_file_path)
    user_id = 'lk356003@gmail.com'

    gmail_connection = get_gmail_connection(credentials)

    inbox_count = get_email_count(gmail_connection, user_id, 'INBOX')
    sent_count = get_email_count(gmail_connection, user_id, 'SENT')
    spam_count = get_email_count(gmail_connection, user_id, 'SPAM')

    print(f'Inbox count: {inbox_count}')
    print(f'Sent count: {sent_count}')
    print(f'Spam count: {spam_count}')

    total_emails = inbox_count + sent_count + spam_count
    total_emission = get_carbon_emission(total_emails)
    print(f'Estimated carbon emission for emails: {total_emission} kilograms of CO2')

if __name__ == '__main__':
    main()
