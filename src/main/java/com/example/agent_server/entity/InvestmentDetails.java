package com.example.agent_server.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class InvestmentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location")
    private String LOCATION;

    @Column(name = "modify_flag")
    private String MODIFYFLAG;

    @Column(name = "scheme_name")
    private String SCHEMENAME;

    @Column(name = "ih_no")
    private Integer IHNO;

    @Column(name = "regsl_no")
    private String REGSLNO;

    @Column(name = "to_scheme")
    private String TOSCHEME;

    @Column(name = "ecs_bank_name")
    private String ECSBANKNAM;

    @Column(name = "start_date")
    private String STARTDATE;

    @Column(name = "`terminated`")
    private Boolean TERMINATED;

    @Column(name = "`zone`")
    private String ZONE;

    @Column(name = "to_productC")
    private String TOPRODUCTC;

    @Column(name = "fund_code")
    private String FUNDCODE;

    @Column(name = "ecs_ac_no")
    private String ECSACNO;

    @Column(name = "plan")
    private String PLAN;

    @Column(name = "prod_code")
    private String PRODCODE;

    @Column(name = "agent_name")
    private String AGENTNAME;

    @Column(name = "scheme")
    private String SCHEME;

    @Column(name = "`status`")
    private String STATUS;

    @Column(name = "to_schemena")
    private String TOSCHEMENA;

    @Column(name = "amount")
    private Double AMOUNT;

    @Column(name = "frequency")
    private String FREQUENCY;

    @Column(name = "escholdern")
    private String ECSHOLDERN;

    @Column(name = "ecs_no")
    private String ECSNO;

    @Column(name = "umrn_code")
    private String UMRNCODE;

    @Column(name = "sip_mode")
    private String SIPMODE;

    @Column(name = "branch")
    private String BRANCH;

    @Column(name = "invd_pid")
    private String INVDPID;

    @Column(name = "reg_date")
    private String REGDATE;

    @Column(name = "agent_code")
    private String AGENTCODE;

    @Column(name = "invclienti")
    private String INVCLIENTI;

    @Column(name = "sub_broker")
    private String SUBBROKER;

    @Column(name = "end_date")
    private String ENDDATE;

    @Column(name = "sip_type")
    private String SIPTYPE;

    @Column(name = "to_plan")
    private String TOPLAN;

    @Column(name = "folio")
    private Double FOLIO;
    
    @Column(name = "noofinstal")
    private Double NOOFINSTAL;

    @Column(name = "tr_type")
    private String TRTYPE;

    @Column(name = "pan")
    private String PAN;

    @Column(name = "dp_invname")
    private String DP_INVNAME;

    @Column(name = "inv_name")
    private String INVNAME;
    
}
