# TestListenerPlugin
A plugin made to test Forge events in a Bukkit environment.

Currently only supports Arclight and Mohist, to my knowledge.

Use `/testlistener fire-event` to test firing an event. Chat should output "ExampleEvent fired."

Use `/testlistener toggle-listener` to toggle the ExampleListener, which is off by default.
Turning on the listener should output "CaptureEvent.SuccessfulCapture fired." in chat when a Pokémon is caught.
When the listener is disabled, it should not have any output when a Pokémon is caught.
