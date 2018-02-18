# Power UP
Team 1677's team code repository for 2018-2019 frc season.

## Roadmap
This will be the road to success. I will attempt to document all the steps that we took to get to x destination

```
0.0 Clean Slate
Use this for a restart or as a template for test functions or ideas

0.1 Controller Beta 
Connect Driver and CoDriver Controllers to the pc and log controller feed back.
	- Joystick Feedback Routine
	- Buttons Initialized
	
0.2 Controller
Add debounce functionality to the buttons so we can prevent triggering of the buttons. And add add a toggle functionality.
	- Button Feedback Routine
        	- Debounce
		- Toggle

0.3 Driver System Beta
Initialize the driver system with mapped out ports and configured motors.
	- List ports on robot map
	- Define Motors
	- Configure CANTalons/Jaguars
	- Configure PID Loop For PID

0.4 Controll System
Develop Multiple Controll Systems to Drivers. 
	- Tank
	- Arcade
	- Arcade (Cheezy Style)

0.5 Motion Profiles
Provide a clean interface for jerk detection to see if we have colided into something and respond to the encounter (Auto Shift Down).
	- NAVX Implementations
	- Motion Profiles
	- Jerk Detection

0.6 Shifting
Develop a automatic and shifting protocal based on speed profiles and command mode's (only relative to Arcade [ Cheezy Style ]) taken from version 0.5 Motion Profiles.
	- Shifting 
	
	- Shifting Automatic 

```

## Ports Diagram 
| Motor Type  | Motor Name  | Port Number |
| :--------:  | :--------:  | :---------: |
| Blank       | LeftMaster  | 0           |
| Blank       | LeftSlave   | 1           |
| Blank       | RightMaster | 2           |
| Blank       | RightSlave  | 3           |

## CoDriver Buttons
_________________________________________
| Button Name  	 | Color  | Port Number |
|:--------------:|:------:|:-----------:| 
| Winch Up	 | Red    | 0           |   
| Winch Down	 | Red    | 1           |  
| Elevator Up	 | Blue   | 2           |
| Elevator Down	 | Blue   | 3           |
| Arm		 | White  | 4           |
| Grabber Open	 | Green  | 5           |
| Grabber close	 | Green  | 6           |
| Intake Forward | Yellow | 7           |
| Intake Reverse | Yellow | 8           |

### Contributers
| Name        | Role             |
| :---------: | :--------------- |
| Josh Brown  | Lead Programmer  |
