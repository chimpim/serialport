package com.chimpim.serialport;


import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class GNUSerialPort implements SerialPort {
    private gnu.io.SerialPort mSerialPort;
    private InputStream mInputStream;
    private OutputStream mOutputStream;

    @Override
    public void open(@NotNull String port, int baudrate) throws SerialPortException {
        try {
            CommPortIdentifier commPortIdentifier = CommPortIdentifier.getPortIdentifier(port);
            mSerialPort = (gnu.io.SerialPort) commPortIdentifier.open("CI303Reader", 0);
            mInputStream = mSerialPort.getInputStream();
            mOutputStream = mSerialPort.getOutputStream();
        } catch (NoSuchPortException e) {
            throw new SerialPortException(String.format("串口(%s)不存在或不可用", port), e);
        } catch (PortInUseException e) {
            throw new SerialPortException(String.format("串口(%s)已被占用", port), e);
        } catch (IOException e) {
            throw new SerialPortException(String.format("串口(%s)IO异常", port), e);
        } catch (Exception e) {
            throw new SerialPortException(String.format("连接串口(%s)失败", port), e);
        }
    }

    @Override
    public synchronized boolean isOpen() {
        return mSerialPort != null;
    }

    @Nullable
    @Override
    public OutputStream getOutputStream() {
        return mOutputStream;
    }

    @Nullable
    @Override
    public InputStream getInputStream() {
        return mInputStream;
    }

    @Override
    public synchronized void close() throws IOException {
        if (mInputStream != null) {
            mInputStream.close();
        }
        if (mOutputStream != null) {
            mOutputStream.close();
        }
        if (mSerialPort != null) {
            mSerialPort.close();
            mSerialPort = null;
        }
    }
}
