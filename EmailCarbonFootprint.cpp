#include <iostream>
#include <map>
#include <string>
using namespace std;

enum class EntityType { EMAIL };

class CarbonFootprint {
public:
    CarbonFootprint(EntityType type, string& email, int inboxCount, int sentCount, int spamCount)
        : entityType(type), entity(email), inboxCount(inboxCount), sentCount(sentCount), spamCount(spamCount) {}

    void getCarbonFootprint() {
        if (entityType == EntityType::EMAIL) {
            cout << "email" << endl;
            cout << "emailId: " << entity << endl;
            cout << "inbox: " << estimateCarbonEmissions(inboxCount) << " KG" << endl;
            cout << "sent: " << estimateCarbonEmissions(sentCount) << " KG" << endl;
            cout << "spam: " << estimateCarbonEmissions(spamCount) << " KG" << endl;
        }
    }
private:
    EntityType entityType;
    string entity;
    int inboxCount;
    int sentCount;
    int spamCount;
    
    double estimateCarbonEmissions(int numberOfEmails) {
        const double CARBON_EMISSIONS_PER_EMAIL = 0.02;
        return numberOfEmails * CARBON_EMISSIONS_PER_EMAIL;
    }
};
int main() {
    map<string, EntityType> entityMap = {
        {"abc@xyz.com", EntityType::EMAIL},
        {"lk356003@gmail.com", EntityType::EMAIL}
    };

    string email;
    int inboxCount, sentCount, spamCount;

    cout << "Enter an email address: ";
    cin >> email;

    if (entityMap.find(email) != entityMap.end()) {
        cout << "Enter the number of emails in the inbox: ";
        cin >> inboxCount;
        cout << "Enter the number of emails sent: ";
        cin >> sentCount;
        cout << "Enter the number of spam emails: ";
        cin >> spamCount;

        CarbonFootprint footprint(entityMap[email], email, inboxCount, sentCount, spamCount);
        footprint.getCarbonFootprint();
    } else {
        cout << "Entity not found" << endl;
    }
    return 0;
}