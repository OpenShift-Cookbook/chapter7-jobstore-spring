# OpenShift Cookbook - Chapter 5 Spring Framework Sample Application#

A simple Job portal written using Java EE 6 and MySQL 5.5

To run it on OpenShift, run the following command.

```
$ rhc app-create jobstore tomcat-7 mysql-5.5 --from-code https://github.com/OpenShift-Cookbook/chapter5-jobstore-spring.git --timeout 180
```
