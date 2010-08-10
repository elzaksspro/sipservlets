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
package org.mobicents.media.server.impl.rtp.sdp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mobicents.media.format.AudioFormat;
import org.mobicents.media.server.spi.MediaType;
import org.mobicents.media.server.spi.rtp.AVProfile;

/**
 *
 * @author kulikov
 * @author amit bhayani
 */
public class XliteSDPTest {

    private SessionDescriptor desc;
    private String sdp = "v=0\n" +
            "o=- 0 2 IN IP4 192.168.2.1\n" +
            "s=CounterPath X-Lite 3.0\n" +
            "c=IN IP4 192.168.2.1\n" +
            "t=0 0\n" +
            "m=audio 7688 RTP/AVP 0 8 101\n" +
            "a=fmtp:101 0-15\n" +
            "a=rtpmap:101 telephone-event/8000\n" +
            "a=alt:1 4 : CoF0Nv2H 5hS404hU 192.168.2.1 7688\n" +
            "a=alt:2 3 : sRdXzWqQ y5uUNWD2 192.168.1.2 7688\n" +
            "a=alt:3 2 : F6ddhsRx Ei6bATWC 10.211.55.2 7688\n" +
            "a=alt:4 1 : Fola+gz2 Pl1XgZb0 10.37.129.2 7688\n";

    public XliteSDPTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        desc = new SessionDescriptor(sdp);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getVersion method, of class Descriptor.
     */
    @Test
    public void testGetVersion() {
        String version = desc.getVersion();
        assertEquals("0", version);
    }

    @Test
    public void testOrigin() {
        assertEquals("-", desc.getOrigin().getName());
        assertEquals("0", desc.getOrigin().getSessionID());
        assertEquals("2", desc.getOrigin().getSessionVersion());
        assertEquals("IN", desc.getOrigin().getNetworkType());
        assertEquals("IP4", desc.getOrigin().getAddressType());
        assertEquals("192.168.2.1", desc.getOrigin().getAddress());
    }

    @Test
    public void testSession() {
        assertEquals("CounterPath X-Lite 3.0", desc.getSession());
    }

    @Test
    public void testConnection() {
        assertEquals("IN", desc.getConnection().getNetworkType());
        assertEquals("IP4", desc.getConnection().getAddressType());
        assertEquals("192.168.2.1", desc.getConnection().getAddress());
    }

    public void testMediaConnection() {

        MediaDescriptor audMedDesc = desc.getMediaDescriptor(0);

        assertEquals("IN", audMedDesc.getConnection().getNetworkType());
        assertEquals("IP4", audMedDesc.getConnection().getAddressType());
        assertEquals("192.168.2.1", audMedDesc.getConnection().getAddress());

        MediaDescriptor videoMedDesc = desc.getMediaDescriptor(1);

        assertEquals("IN", videoMedDesc.getConnection().getNetworkType());
        assertEquals("IP4", videoMedDesc.getConnection().getAddressType());
        assertEquals("192.168.2.1", videoMedDesc.getConnection().getAddress());
    }

    @Test
    public void testMediaDescriptor() {
        assertEquals(1, desc.getMediaTypeCount());
        MediaDescriptor audMedDesc = desc.getMediaDescriptor(0);

        assertEquals("audio", audMedDesc.getMediaType().getName());
        assertEquals(7688, audMedDesc.getPort());
        assertEquals(3, audMedDesc.getFormatCount());

        assertEquals(0, audMedDesc.getPyaloadType(0));
        assertEquals(8, audMedDesc.getPyaloadType(1));
        assertEquals(101, audMedDesc.getPyaloadType(2));

        assertEquals(AVProfile.PCMU, audMedDesc.getFormat(0));
        assertEquals(AVProfile.PCMA, audMedDesc.getFormat(1));
        assertEquals(AVProfile.DTMF, audMedDesc.getFormat(2));
    }

    @Test
    public void testToString() {
        String s = "v=0\n" +
                "o=- 8 2 IN IP4 192.168.1.2\n" +
                "s=CounterPath X-Lite 3.0\n" +
                "c=IN IP4 192.168.1.2\n" +
                "t=0 0\n" +
                "m=audio 39958 RTP/AVP 0 101\n" +
                "a=alt:1 1 : aZNEKdX5 FpbpFGUv 192.168.1.2 39958\n" +
                "a=rtpmap:0 pcma/8000\n" +
                "a=rtpmap:101 telephone-event/8000\n" +
                "a=fmtp:101 0-15\n" +
                "a=control:audio\n" +
                "a=silenceSupp:off";
        SessionDescriptor sd = new SessionDescriptor();
        sd.setSession("CounterPath X-Lite 3.0");
        sd.createOrigin("-", "8", "2", "IN", "IP4", "192.168.1.2");
        sd.createConnection("IN", "IP4", "192.168.1.2");
        MediaDescriptor md = sd.addMedia(MediaType.AUDIO, 39958);
        md.addAttribute("alt:1 1 : aZNEKdX5 FpbpFGUv 192.168.1.2 39958");
        md.addFormat(0, AVProfile.PCMA);
        md.addFormat(101, AVProfile.DTMF);
        System.out.println(sd.toString());
    //assertEquals(s, sd.toString());
    }

    @Test
    public void testAudioMediaDescriptor() {

        AudioFormat amrFormat = new AudioFormat(AudioFormat.AMR, 8000.0, AudioFormat.NOT_SPECIFIED, 1);

        String s = "m=audio 0 RTP/AVP 97\n" +
                "b=AS:8\n" +
                "a=rtpmap:97 AMR/8000/1\n" +
                "a=control:trackID=4\n" +
                "a=fmtp:97 octet-align=1";

        SessionDescriptor desc1 = new SessionDescriptor(s, false);
        MediaDescriptor md = desc1.getMediaDescriptor(MediaType.AUDIO);
        assertNotNull(md);

        assertTrue(md.getFormatCount() == 1);
        assertEquals(amrFormat, md.getFormat(0));
    }
}