import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ollir.OllirEmitter;
import pt.up.fe.comp.jmm.JmmNode;
import pt.up.fe.comp.jmm.analysis.JmmSemanticsResult;
import pt.up.fe.comp.jmm.analysis.table.SymbolTable;
import pt.up.fe.comp.jmm.ollir.JmmOptimization;
import pt.up.fe.comp.jmm.ollir.OllirResult;
import pt.up.fe.comp.jmm.report.Report;

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

public class OptimizationStage implements JmmOptimization {
    private boolean oOptimization = false;
    private int rOptimization = 0;

    public OptimizationStage(boolean oOptimization, int rOptimization){
        this.oOptimization = oOptimization;
        this.rOptimization = rOptimization;
    }

    public OptimizationStage(){
        this.rOptimization = 0;
        this.oOptimization = false;
    }

    @Override
    public OllirResult toOllir(JmmSemanticsResult semanticsResult) {

        JmmNode node = semanticsResult.getRootNode();
        SymbolTable table = semanticsResult.getSymbolTable();

        // More reports from this stage
        List<Report> reports = new ArrayList<>();

        OllirEmitter emitter = new OllirEmitter(semanticsResult.getSymbolTable(), semanticsResult.getRootNode(), rOptimization, oOptimization, reports);

        // Convert the AST to a String containing the equivalent OLLIR code
        String ollirCode = emitter.getOllirCode(); // Convert node ...
        System.out.println(ollirCode);

        return new OllirResult(semanticsResult, ollirCode, reports);
    }

    @Override
    public JmmSemanticsResult optimize(JmmSemanticsResult semanticsResult) {
        // THIS IS JUST FOR CHECKPOINT 3
        return semanticsResult;
    }

    @Override
    public OllirResult optimize(OllirResult ollirResult) {
        // THIS IS JUST FOR CHECKPOINT 3
        return ollirResult;
    }

}
