public class BancoMatrices {
    public String[][] bancoMatrices = {
            {"AGAACG",
             "CAGTGC",
             "TTAGGT",
             "AGGAGG",
             "GCCCTA",
             "TCACTG"
            },
            {       "CTTTGG",
                    "CAGTGC",
                    "TTATGT",
                    "AGAAGG",
                    "CCCCTA",
                    "TCACTG"
            },
            {"AAGAAA",
             "ACTCGT",
             "TGTATG",
             "GGTGHG",
             "TCTCCA",
             "TCACTG"
            },
            {       "ATGCGA",
                    "CAGTGC",
                    "TTATGT",
                    "AGAAGG",
                    "CCCCTA"
            },
            {"GTCGTA",
             "CAGTGC",
             "TTATGT",
             "AGAAGG",
             "CGCCTA",
             "TCACTG"
            },
            {       "ACAATA",
                    "CAGTGC",
                    "TTATAT",
                    "AGAAGG",
                    "CCACTA",
                    "TAACTG"
            },
            {"AAAGGG", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"
            },
            {"ATGGGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"},
            {"GGGAGG", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"},
            {"ATCGTA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"}
    };

    public String[][] getBancoMatrices() {
        return bancoMatrices;
    }

    public void setBancoMatrices(String[][] bancoMatrices) {
        this.bancoMatrices = bancoMatrices;
    }

    public BancoMatrices(){

    };

    public BancoMatrices(String[][] bancoMatrices) {
        this.bancoMatrices = bancoMatrices;
    }
}
