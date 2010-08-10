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

package org.mobicents.media.server.impl.resource.prelay;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mobicents.media.Format;
import org.mobicents.media.server.impl.dsp.DspFactory;
import org.mobicents.media.server.impl.dsp.Processor;
import org.mobicents.media.server.impl.dsp.audio.g711.alaw.DecoderFactory;
import org.mobicents.media.server.impl.dsp.audio.g711.alaw.EncoderFactory;
import org.mobicents.media.server.impl.resource.Proxy;
import org.mobicents.media.server.impl.resource.cnf.Splitter;
import org.mobicents.media.server.impl.rtp.RtpFactory;
import org.mobicents.media.server.impl.rtp.RtpSocketImpl;
import org.mobicents.media.server.spi.MediaType;
import org.mobicents.media.server.spi.dsp.CodecFactory;

/**
 *
 * @author kulikov
 */
public class CodecSelectionTest {

    private Proxy proxy;
    private Processor dsp;
    private RtpSocketImpl socket;
    private Splitter splitter;
    
    public CodecSelectionTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
/*        Timer timer = new TimerImpl();
        timer.start();
        
        proxy = new Proxy("proxy");
        
        // configuring Packet relay endpoint
        ArrayList<CodecFactory> codecs = new ArrayList();
        codecs.add(new EncoderFactory());
        codecs.add(new DecoderFactory());
        
        DspFactory dspFactory = new DspFactory();
        dspFactory.setName("dsp");
        
        dspFactory.setCodecFactories(codecs);
        dsp = (Processor) dspFactory.newInstance(null);
        
        
        Hashtable<Integer, Format> rtpMap = new Hashtable();
        rtpMap.put(3, AVProfile.PCMA);
//        rtpMap.put(101, AVProfile.DTMF);

        AVProfile profile = new AVProfile();
        profile.setProfile(rtpMap);
        
        // creating dsp factory with g711 encoder/decoder
        Hashtable<MediaType, List<CodecFactory>> codecFactories = new Hashtable();
        codecFactories.put(MediaType.AUDIO, codecs);
        
        
        RtpFactory rtpFactory = new RtpFactory();
        rtpFactory.setCodecs(codecFactories);
        
        rtpFactory.setBindAddress("localhost");
        rtpFactory.setTimer(timer);
        rtpFactory.setAVProfile(profile);
        
        socket = rtpFactory.getRTPSocket(MediaType.AUDIO);
        
        splitter = new Splitter("splitter");
 */ 
    }

    @After
    public void tearDown() {
    }


    /**
     * Test of getSink method, of class Bridge.
     */
    @Test
    public void testFormatNegotiation() throws Exception {        
/*        proxy.getOutput().connect(dsp.getInput());
        dsp.getOutput().connect(splitter);
        
        socket.setFormat(3, AVProfile.PCMA);
        socket.getReceiveStream().connect(proxy.getInput());
        socket.getReceiveStream().start();
        
        System.out.println(dsp.getActiveCodec());
        Thread.currentThread().sleep(5000);
 */ 
    }

}