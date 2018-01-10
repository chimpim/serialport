package com.chimpim.serialport.util;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import org.jetbrains.annotations.NotNull;

import java.util.Enumeration;
import java.util.Vector;

public class GNUSerialPortUtils {
    /**
     * 获取全部串口号
     *
     * @return 全部串口
     */
    public static Vector<CommPortIdentifier> getAllSerialPorts() {
        Enumeration portList = CommPortIdentifier.getPortIdentifiers();
        Vector<CommPortIdentifier> vec = new Vector<>();
        while (portList.hasMoreElements()) {
            vec.add((CommPortIdentifier) portList.nextElement());
        }
        return vec;
    }

    public static Vector<String> getAllSerialPortsAsString() {
        Enumeration portList = CommPortIdentifier.getPortIdentifiers();
        Vector<String> vec = new Vector<>();
        while (portList.hasMoreElements()) {
            vec.add(((CommPortIdentifier) portList.nextElement()).getName());
        }
        return vec;
    }

    public static boolean setComputerRate(@NotNull SerialPort serialPort, int baudRate) {
        try {
            serialPort.setSerialPortParams(
                    baudRate,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            return true;
        } catch (UnsupportedCommOperationException e) {
            e.printStackTrace();
            return false;
        }
    }
}
