/*
 * JBoss, Home of Professional Open Source
 * Copyright XXXX, Red Hat Middleware LLC, and individual contributors as indicated
 * by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a full listing
 * of individual contributors.
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU General Public License, v. 2.0.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License,
 * v. 2.0 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */
package org.mobicents.media.server.impl.resource.test;

import org.mobicents.media.Buffer;
import org.mobicents.media.Format;
import org.mobicents.media.Server;
import org.mobicents.media.format.AudioFormat;
import org.mobicents.media.server.impl.AbstractSource;
import org.mobicents.media.server.spi.Endpoint;

/**
 * Generates sine wave signal with specified Amplitude and frequence.
 *
 * The format of output signal is Linear, 16bit, 8kHz.
 * 
 * @author Oleg Kulikov
 */
public class SineGenerator extends AbstractSource {

    private final static AudioFormat LINEAR_AUDIO = new AudioFormat(
            AudioFormat.LINEAR, 8000, 16, 1,
            AudioFormat.LITTLE_ENDIAN,
            AudioFormat.SIGNED);
    private final static Format FORMAT[] = new Format[]{LINEAR_AUDIO};
    private int f;
    private short A = Short.MAX_VALUE;
    private double dt;
    private int pSize;
    private double time;

    public SineGenerator(String name) {
        super(name);
        init();
//        setFormat(LINEAR_AUDIO);
    }

    /** Creates a new instance of Generator */
    public SineGenerator(Endpoint endpoint, String name) {
        super(name);
        init();
    }

    private void init() {
        //number of seconds covered by one sample
        dt = 1 / LINEAR_AUDIO.getSampleRate();
    }

    public void setAmplitude(short A) {
        this.A = A;
    }

    public short getAmplitude() {
        return A;
    }

    public void setFrequency(int f) {
        this.f = f;
    }

    public int getFrequency() {
        return f;
    }

    private short getValue(double t) {
        return (short) (A * Math.sin(2 * Math.PI * f * t));
    }

    public void evolve(Buffer buffer, long timestamp) {
        int k = 0;

        int frameSize = (int) ((double) 20 / 1000.0 / dt);

        byte[] data = new byte[2 * frameSize];
        for (int i = 0; i < frameSize; i++) {
            short v = getValue(time + dt * i);
            data[k++] = (byte) v;
            data[k++] = (byte) (v >> 8);
        }
        buffer.setData(data);
        buffer.setOffset(0);
        buffer.setLength(data.length);
        buffer.setDuration(20);
        buffer.setTimeStamp(Server.scheduler.getTimestamp());
        time += ((double) 20) / 1000.0;
    }

    public Format[] getFormats() {
        return FORMAT;
    }
}
