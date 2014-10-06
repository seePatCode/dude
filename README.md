Dude
=========

Dude is a webapp for sharing contacts with your friends. One "contact book" to rule them all.

Dude is a Grails 2.4.3 Web App designed to support CommerceHub's Front End Hackathon Meetup on 10/18. The backend is postgresql due to the fact that it is Heroku's default DB choice. 

The Dude elevator pitch:

> Don't know Bob's number but you know that your buddy Jim knows it? Simply
> friend Jim on *Dude* and voila! You have Bob's number! *Dude* is all about sharing
> so that your never lost without a contact.


Version
----

0.1


Setting up your environment
--------------

**1.  Java SE Development Kit 8**

a. Find your appropriate download link here: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

b. Set up your JAVA_HOME path: http://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t/index.html

c. Open a command prompt and make sure 'javac -version' spits back 1.8

**2.  Intellij Ultimate - (It has cleaner grails integration than community. Just do the 30 day trial)**
a. Get the ultimate! http://www.jetbrains.com/idea/download/

**3.  Grails**
a. Go to https://grails.org/download and click the download link.

b. Click the "Installation" button to follow the directions on setting up your environment (Environment Variables an what not...).

c. Open a command prompt and make sure 'grails --version' spits back 2.4.3

**4.  PostgresSQL**

1. You don't need to set up a local instance, but that's how I like to work. Go to [http://www.postgresql.org/download/] and grab a copy!

**5. Heroku**

a. The Production environment is set up to run on heroku. You can follow the steps here (https://devcenter.heroku.com/articles/getting-started-with-grails) to get your machine set up for deploying to heroku.
