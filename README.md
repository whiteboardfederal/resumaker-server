# resumaker-server

## Running server

Navigate to your directory and use command ./gradleW bootRun (gradleW bootRun on Windows 10). Navigate to http://localhost:8080 in your browser.

## Logging in
The current default username is 'user'. For now, your password will be output in the terminal, just copy and paste it. Command line output should look similar to the output below (password is random):
```
Using generated security password: 3c971a67-a225-4ea6-ba45-46be6a41ea76
```


## Install Gradle on Ubuntu
Update and install java-8
```
$ sudo apt update
```
```
$ sudo apt install openjdk-8-jdk
```

Download Gradle and unzip
```
$ wget https://services.gradle.org/distributions/gradle-6.1.1-bin.zip -P /tmp
```
```
$ sudo unzip -d /opt/gradle /tmp/gradle-*.zip
```

Setup Environment Variables
```
$ sudo vi /etc/profile.d/gradle.sh
export GRADLE_HOME=/opt/gradle/gradle-5.2.1
export PATH=${GRADLE_HOME}/bin:${PATH}
```
```
$ source /etc/profile.d/gradle.sh
```

Verify Installation
```
$ gradle -v

------------------------------------------------------------
Gradle 6.1.1
------------------------------------------------------------

Build time:   2020-01-24 22:30:24 UTC
Revision:     a8c3750babb99d1894378073499d6716a1a1fa5d

Kotlin:       1.3.61
Groovy:       2.5.8
Ant:          Apache Ant(TM) version 1.10.7 compiled on September 1 2019
JVM:          11.0.5 (Oracle Corporation 11.0.5+10-LTS)
OS:           Linux 5.3.0-26-generic amd64
```

## Testing with Postman
![Postman Visualize](/images/postman.png)
To test with postman, select 'Basic Auth' in the Authorization tab and simply enter 'user' and the generated security password as listed above.