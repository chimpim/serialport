package com.chimpim.serialport;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;


public interface SerialPort extends Closeable {

    void open(@NotNull String port, int baudrate) throws SerialPortException;

    boolean isOpen();

    @Nullable
    OutputStream getOutputStream();

    @Nullable
    InputStream getInputStream();


}
