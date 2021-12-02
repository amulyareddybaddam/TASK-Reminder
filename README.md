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

### New Remainder Activity
- Here the new remainder is created.
-	It consists of Edit Text where we will take the name/description of the remainder.
-	A radio button for enable or disable the remainder.
-	Early reminder checkbox for reminding a day before or in the morning of the reminder.
-	One button to set the date.
-	One button to set the time.
-	One button “Done” to set the remainder.
- One button to cancel the remainder.	

### Reminder List Activity

- It shows the dashboard and it also consists of list view where all the remainders can be seen.
- Here in the list view we can see the remainder with date, time and we can also have buttons to edit and delete the remainder.

### Ringing Activity

- This page pops up when the remainder is set and alarm ringing.
- It shows the name/description of the remainder in Text View.
- It also consists a button to dismiss the alarm which redirects to the dashboard.

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

