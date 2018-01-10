package com.chimpim.serialport.util;

import android_serialport_api.SerialPortFinder;

import java.util.Arrays;
import java.util.Vector;

public class AndroidSerialPortUtils {

    public static Vector<String> getAllSerialPortsAsString() {
        String[] allDevicesPath = new SerialPortFinder().getAllDevicesPathNonRepeating();
        Vector<String> serialPorts = new Vector<>(allDevicesPath.length);
        serialPorts.addAll(Arrays.asList(allDevicesPath));
        return serialPorts;
    }

}
