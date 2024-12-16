package com.example.agent_server.models;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvestmentDetailsDTO {
    
    private String LOCATION;

    private String MODIFYFLAG;

    private String SCHEMENAME;
    
    private Integer IHNO;

    private String REGSLNO;

    private String TOSCHEME;

    private String ECSBANKNAM;
   
    private String STARTDATE;

    private Boolean TERMINATED;

    private String ZONE;

    private String TOPRODUCTC;

    private String FUNDCODE;

    private String ECSACNO;

    private String PLAN;

    private String PRODCODE;

    private String AGENTNAME;
   
    private String SCHEME;

    private String STATUS;

    private String TOSCHEMENA;
    
    private Double AMOUNT;

    private String FREQUENCY;

    private String ECSHOLDERN;

    private String ECSNO;

    private String UMRNCODE;

    private String SIPMODE;

    private String BRANCH;

    private String INVDPID;

    private String REGDATE;

    private String AGENTCODE;

    private String INVCLIENTI;

    private String SUBBROKER;

    private String ENDDATE;

    private String SIPTYPE;

    private String TOPLAN;

    private Double FOLIO;
    
    private Double NOOFINSTAL;

    private String TRTYPE;

    private String PAN;

    private String DP_INVNAME;

    private String INVNAME;
}
