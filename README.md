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
Set up Remote repository -> Create new project (empty template) -> Gradle build (change target sdk 33 & add temi sdk version in dependencies & set apk name) -> Android manifest (add metadata taken from temi sdk) -> basic application implements onrobotreadylistener interface (copy in on create) -> settings on safe action check all for automatic code clean up

From SDK get 

- onStart
- OnStop 
- onRobotReady

Editing UI with XML - use landscape desktop to simulate the output


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


### Transitions to other screens 
Solution 1: Fragmenting (Kotlin)

Refer to DoorRingMi/CallMi 

Fragment is a modular section that can be added or removed based on user's interaction with the map. Allows the activity to be broken down so  that it can be updated or replaced independently. 

Fragments must be hosted inside an activity and multiple fragments can be combined to create complex user interfaces. 

To create a fragment in your app, you typically create a Java or Kotlin class that extends the Fragment class, and then define the layout for the fragment in an XML layout file. You can then add the fragment to an activity using the FragmentManager and FragmentTransaction classes.

```
// Define a fragment class
class MyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the fragment layout
        return inflater.inflate(R.layout.fragment_my, container, false)
    }
}

// Add the fragment to an activity
val fragmentManager = supportFragmentManager
val transaction = fragmentManager.beginTransaction()
transaction.add(R.id.fragment_container, MyFragment())
transaction.commit()
```

Solution 2: Activity to another activity

This method is slower and harder to deal with persisting states.

