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

package org.mobicents.media.server.impl.resource.cnf;

import org.mobicents.media.server.impl.resource.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mobicents.media.Server;
import static org.junit.Assert.*;
import org.mobicents.media.server.impl.resource.test.TransmissionTester;

/**
 *
 * @author kulikov
 */
public class SplitterTest {

    private Server server;
    private Splitter splitter;
    private TransmissionTester tester;
    
    public SplitterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        server = new Server();
        server.start();
        
        splitter = new Splitter("test");
        tester = new TransmissionTester();
    }

    @After
    public void tearDown() {
        server.stop();
    }

    /**
     * Test of start method, of class Proxy.
     */
    @Test
    public void testTransmission() {
        tester.connect(splitter.getInput());
        tester.connect(splitter);
        splitter.start();
        tester.start();
        assertTrue(tester.getMessage(), tester.isPassed());
        splitter.stop();
    }

}