#include <iostream>
#include <curl/curl.h>
#include <string>

using namespace std;

int getEmailCounts(const string& username, const string& password) {
    CURL *curl;
    CURLcode res = curl_global_init(CURL_GLOBAL_DEFAULT);
    if (res != CURLE_OK) {
        cerr << "CURL initialization error" << endl;
        return -1;
    }

    curl = curl_easy_init();
    if (curl) {
        string url = "imaps://imap.gmail.com/INBOX";
        curl_easy_setopt(curl, CURLOPT_URL, url.c_str());

        string login = username + ":" + password;
        curl_easy_setopt(curl, CURLOPT_USERPWD, login.c_str());

        curl_easy_setopt(curl, CURLOPT_CUSTOMREQUEST, "STATUS INBOX (MESSAGES)");
        curl_easy_setopt(curl, CURLOPT_CUSTOMREQUEST, "STATUS INBOX (UNSEEN)");

        res = curl_easy_perform(curl);

        if (res != CURLE_OK) {
            cerr << "CURL request error: " << curl_easy_strerror(res) << endl;
        }

        curl_easy_cleanup(curl);
    }

    curl_global_cleanup();

    return 0;
}

int main() {
    string username;
    string password;

    cout << "Enter your email: ";
    cin >> username;

    cout << "Enter your password: ";
    cin >> password;

    int emailCounts = getEmailCounts(username, password);
    if (emailCounts != -1) {
        double carbonEmissionFactor = 0.3;
        double carbonEmission = emailCounts * carbonEmissionFactor;
        cout << "Carbon Emission for email " << carbonEmission << " units" << endl;
    }

    return 0;
}