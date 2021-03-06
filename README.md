# TASK-Reminder

## Team-7 Team Members
1. Vivek Tadiparthi
2. Sai Naga Anu Teja Gunda
3. Amulya Baddam
4. Nandini Kandi

### Application Description
Here in this app, users can get the remainder of tasks on time by saving the request prior by giving respective information in this application. User can schedule remainder task by giving date and time. Without enabling request user can create them. Priority wise requests can be made by the users so that important requests can be reminded first. This app will be used mainly for not forgetting the works to be done on timely base which makes things easier.

### Main Activity
- This screen consists of menu bar for selecting Dashboard, Help, Rate US, and Exit.
- We also have a button which takes us to the New remainder activity where we can create a new remainder.

![Screenshot (114)](https://user-images.githubusercontent.com/77635770/144763448-d030fb94-975c-4e25-9fc9-43fbecdd7880.png)

![Screenshot (115)](https://user-images.githubusercontent.com/77635770/144763508-a45ea6fa-c95b-4abe-b2c3-579fccc5aab2.png)

![Screenshot (116)](https://user-images.githubusercontent.com/77635770/144763613-8796acb8-0354-48fa-a629-000b63344307.png)

![Screenshot (112)](https://user-images.githubusercontent.com/77635770/144762752-eb5d05c6-ba93-4b47-a972-818634850f55.png)

### New Remainder Activity
- Here the new remainder is created.
-	It consists of Edit Text where we will take the name/description of the remainder.
-	A radio button for enable or disable the remainder.
-	Early reminder checkbox for reminding a day before or in the morning of the reminder.
-	One button to set the date.
-	One button to set the time.
-	One button “Done” to set the remainder.
- One button to cancel the remainder.	

![Screenshot (95)](https://user-images.githubusercontent.com/77635770/144763645-84472eb6-98ec-4b10-8440-20b03f0b9b16.png)

![Screenshot (97)](https://user-images.githubusercontent.com/77635770/144763655-fc77d250-c606-4232-b1a3-783c1dbccac5.png)

### Reminder List Activity

- It shows the dashboard and it also consists of list view where all the remainders can be seen.
- Here in the list view we can see the remainder with date, time and we can also have buttons to edit and delete the remainder.

![Screenshot (108)](https://user-images.githubusercontent.com/77635770/144763682-81bb19dd-d46c-42e3-973f-c6e3c2badd98.png)

### Ringing Activity

- This page pops up when the remainder is set and alarm ringing.
- It shows the name/description of the remainder in Text View.
- It also consists a button to dismiss the alarm which redirects to the dashboard.

![Screenshot (99)](https://user-images.githubusercontent.com/77635770/144763707-fdcdf317-317f-445a-9c8c-b4998631b754.png)

![Screenshot (106)](https://user-images.githubusercontent.com/77635770/144763710-53a84bb5-e175-46a4-8f9e-5f1506e16e32.png)

### Supported Devices:

-	only works in android devices.
-	Android 5.0(Lollipop) and above versions.
-	Minimum sdk version 21 and target sdk version 29.

### Database:

-	For our Android application, we use a SQLite database.
-	SQLite is a database that stores data in an organized format. The performance of SQLite is superior.
-	SQLite databases may also be queried, with significantly more robust data retrieval.
-	This database is used to hold reminders, dates, times, days, alarms, and timers.

### To run this application locally, follow these instructions:

-	Get new code on a regular basis. 
-	get the most recent code (Fork and clone if this is the first time).

### Using the command line to clone a repository:

-	Navigate to the repository's home page on the github repo.
-	On the main page of the repository, click the Code button.
-	We can clone using HTTPS or SSH after clicking on the code.
-	Copy the URL supplied by clicking on the appropriate tab.
-	Open Git bash now (some tools need to be installed like tortoisegit, gitbash)
-	update the current working directory to the location where the cloned directory will be created.
-	After that, type "git clone" and paste the URL you copied previously.
-	press "Enter" to create your local clone.
-	Then open this folder using "Android studio" and then run this app using emulator.

### Status of Completion:

-	The option to set a new reminder is available on the welcome page — Completed
-	Create a page where users may add new reminders to their calendars — Completed
-	In the Create Reminder Activity – Completed, there is a checkbox option to enable or disable the alarm.
-	Even after selecting the disable option for the reminder - Completed, the user can still access all of the reminders in the dashboard as a list.
-	When the user clicks the Date button when creating a new reminder, the date picker dialog box appears – Completed
-	When the user clicks the Time button when creating a new reminder, the Time picker dialog box appears – Completed
-	Setting the reminder priority to high (visible in red), medium (visible in blue), or low (visible in green) in the create reminder activity page – Completed
-	Finished the main activity of displaying the reminders in the main dashboard.
-	Ringing Activity– User can ignore or snooze the alarm– Completed.
-	Ringing Activity – When the user presses the snooze button, the alarm will continue to ring – Completed.
-	Rate us page – allows the user to give the program a rating – completed.
-	Page about us – This page primarily describes the application – Completed.

### References:

-	For adding API key
-	SQLite
-	app logo

### Persist: 

- After the user sets the alarm reminder and then dismisses it, the user can still access the remaining in the dashboard and edit or delete it.

