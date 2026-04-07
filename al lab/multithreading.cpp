#include <bits/stdc++.h>
#include <thread>
#include <chrono>
#include <random>
using namespace std;

class cube {
int x;
public:
cube(int n) {
x = n;
}
void run() {
int c = x * x * x;
cout << "Cube is: " << c << endl;
}
};

class square {
int x;
public:
square(int n) {
x = n;
}
void run() {
int c = x * x;
cout << "Square is: " << c << endl;
}
};

class Number {
public:
void run() {
random_device rd;
mt19937 gen(rd());
uniform_int_distribution<> dis(1, 100);

```
    for (int i = 0; i < 10; i++) {
        int randomInt = dis(gen);
        cout << "RANDOM NO: " << randomInt << endl;

        square s(randomInt);
        cube c(randomInt);

        thread t1(&square::run, &s);
        thread t2(&cube::run, &c);

        t1.join();
        t2.join();

        this_thread::sleep_for(chrono::seconds(1));
    }
}
```

};

int main() {
Number n;
thread t(&Number::run, &n);
t.join();
return 0;
}
