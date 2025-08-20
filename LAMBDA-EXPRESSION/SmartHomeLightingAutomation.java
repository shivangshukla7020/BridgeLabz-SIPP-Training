// Lambda Expressions – Smart Home Lighting Automation

class Light {
    void turnOnPattern(String pattern) {
        print "Lights set to: " + pattern;
    }
}

class SmartHome {
    Consumer<Light> motionTrigger = (light) -> light.turnOnPattern("Motion pattern: hallway glow");
    Consumer<Light> timeTrigger = (light) -> light.turnOnPattern("Evening pattern: warm lights");
    Consumer<Light> voiceTrigger = (light) -> light.turnOnPattern("Voice command pattern: reading mode");

    void test() {
        Light l = new Light();
        motionTrigger.accept(l);
        timeTrigger.accept(l);
        voiceTrigger.accept(l);
    }
}
