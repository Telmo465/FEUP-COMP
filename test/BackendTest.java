
/**
 * Copyright 2021 SPeCS.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License. under the License.
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pt.up.fe.comp.TestUtils;
import pt.up.fe.comp.jmm.ollir.OllirResult;
import pt.up.fe.comp.jmm.ollir.OllirUtils;
import pt.up.fe.specs.util.SpecsIo;

import java.util.ArrayList;

public class BackendTest {

    @Test
    public void testHelloWorld() {
        //var result = TestUtils.backend(new OllirResult(OllirUtils.parse(SpecsIo.getResource("fixtures/public/ollir/myClass3.ollir")), null, new ArrayList<>()));
        //var result = TestUtils.backend(SpecsIo.getResource("fixtures/public/Simple.jmm"));
        //var result = TestUtils.backend(new OllirResult(OllirUtils.parse(SpecsIo.getResource("fixtures/public/ollir/myclass3.ollir")), null, new ArrayList<>()));
        var result = TestUtils.backend(SpecsIo.getResource("fixtures/public/Reverse.jmm"));
        TestUtils.noErrors(result.getReports());
        var output = result.run();
        //assertEquals("Hello, World!", output.trim());
    }

    @Test
    public void IIncOptimizationTest() {
        var result = TestUtils.backend(SpecsIo.getResource("fixtures/public/IIncOptimization.jmm"));
        TestUtils.noErrors(result.getReports());

        var output = result.run();
        assertEquals("128\r\n" +
                "230\r\n" +
                "-712\r\n" +
                "37000\r\n" +
                "395\r\n" +
                "38256", output.trim());
    }

    @Test
    public void testNoConsecutive() {
        //var result = TestUtils.backend(new OllirResult(OllirUtils.parse(SpecsIo.getResource("fixtures/public/ollir/myClass3.ollir")), null, new ArrayList<>()));
        //var result = TestUtils.backend(SpecsIo.getResource("fixtures/public/Simple.jmm"));
        //var result = TestUtils.backend(new OllirResult(OllirUtils.parse(SpecsIo.getResource("fixtures/public/ollir/myclass3.ollir")), null, new ArrayList<>()));
        var result = TestUtils.backend(SpecsIo.getResource("fixtures/public/life.jmm"));
        TestUtils.noErrors(result.getReports());
        var output = result.run("5");
        //assertEquals("Hello, World!", output.trim());
    }

    @Test
    public void testTicTacToe() {
        var result = TestUtils.backend(SpecsIo.getResource("fixtures/public/TicTacToe.jmm"));
        TestUtils.noErrors(result.getReports());

        var output = result.run("0\n" +
                "0\n" +
                "0\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "0\n" +
                "2\n" +
                "2");
    }
}
