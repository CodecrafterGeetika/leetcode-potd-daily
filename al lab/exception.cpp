#include<stdexcept>
#include<iostream>

using namespace std;

int Division (int a, int b) {
    if (b == 0) {
        throw runtime_error("Incorect \n");
    }
    return a/b;
}
int main() {
    int a,b,result;
    cout << "enter number: \n";
    cin >> a;
    cout << "enter number: \n";
    cin >> b;
    try {
       result= Division(a,b);
       cout << "Quotient is " << result << endl;
    } catch(runtime_error &e) {
        cout << "Exception occured \n";
    }
}
