# FirstTemiApp

This repository documents my learnings in my internship with RoboSolutions. 

Robosolutions Singapore is the exclusive distributor of Temi Robot Singapore. In my time here as an intern, I will be developing Android Applications in Java and Kotlin.

Temi's SDK is available [here](https://github.com/robotemi/sdk/tree/master)

Sample picture of the Models available

![Temi Models](/Images/FRAME_ROBOTS_v2_3_txt3.png)

This App will be used to practice implementing different features, hence the features it contain may not come together coherently. 

## Useful ADB commands
- adb connect <ip_address>
- adb devices 
- adb disconnect 
- adb exec-out screencap -p > <name_of_screenshot>.png  


## Creating a new Application 
Used Android Studio 64 Dolphin 

Workflow: 
Set up Remote repository -> Create new project (empty template) -> Gradle build (change target sdk 33 & add temi sdk version in dependencies & set apk name) -> Android manifest (add metadata taken from temi sdk) -> basic application implements onrobotreadylistener interface (copy in on create)

From SDK get 

- onStart
- OnStop 
- onRobotReady


## 4 button grid configuration (Exploring Movement/Speech capabilities) 

![Interactive buttons that allow temi to rotate and speak when pressed](/Images/grid.png)

### Referencing the buttons 
Buttons are stored as attributes and declared with the Class. 
Initialised and assigned in onCreate through 
```
findViewById(R.id.<name_in_xml>)

btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
            }
        });
```
### TTS Request for speech 
Refer to the documentation [here](https://github.com/robotemi/sdk/wiki/Speech#ttsRequest)

<B>Note</B> that the TTSRequest uses a factory method 
```
TtsRequest.create(<Insert_speech_here>)
```
Only speech is mandatory. 


Notes on each module: 
- Movement
    - Turning and tilt work as expected 
    - Skidjoy has some issues (see issue #1) 
- Speech 
    - Speak works as expected

