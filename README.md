# OpenShift Cookbook - Chapter 7 Spring Framework Sample Application#

A simple Job portal written using Spring framework 4.0.3.RELEASE and MySQL 5.5

To run it on OpenShift, run the following command.

```
$ rhc create-app jobstore tomcat-7 mysql-5.5 --from-code https://github.com/OpenShift-Cookbook/chapter7-jobstore-spring.git --timeout 180
```
