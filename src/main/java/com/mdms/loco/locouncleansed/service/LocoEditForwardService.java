package com.mdms.loco.locouncleansed.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;
import com.mdms.loco.locouncleansed.model.LocoDataFois;
import com.mdms.loco.locouncleansed.model.MLocoBoggie;
import com.mdms.loco.locouncleansed.model.MLocoBrakeType;
import com.mdms.loco.locouncleansed.model.MLocoShed;
import com.mdms.loco.locouncleansed.model.MLocoStoreAuxilary;
import com.mdms.loco.locouncleansed.model.MLocoTractionMotor;
import com.mdms.loco.locouncleansed.repository.LocoDataFoisRepository;
import com.mdms.loco.locouncleansed.repository.LocoUncleansedDataElectricRepository;
import com.mdms.loco.locouncleansed.repository.LocoUncleansedDataRepository;
import com.mdms.loco.locouncleansed.repository.MLocoBoggieRepository;
import com.mdms.loco.locouncleansed.repository.MLocoBrakeTypeRepository;
import com.mdms.loco.locouncleansed.repository.MLocoShedRepository;
import com.mdms.loco.locouncleansed.repository.MLocoStoreAuxilaryRepository;
import com.mdms.loco.locouncleansed.repository.MLocoTractionMotorRepository;
import com.mdms.loco.locouncleansed.repository.MLocoTypeRepository;

import com.mdms.loco.locouncleansed.model.MLocoType;


@Service
public class LocoEditForwardService {
	
	
	@Autowired
	private LocoDataFoisRepository obj_uncleansedrepo;
	@Autowired
private MLocoTypeRepository obj_uncleansedtyperepo;
	@Autowired
	LocoUncleansedDataElectricRepository obj_elec;
//	   
	@Autowired
	private LocoUncleansedDataRepository obj_uncleansedcommonrepo;
	
	@Autowired
	private MLocoShedRepository obj_shedrepo;
	@Autowired
	private MLocoBrakeTypeRepository obj_breaktyperepo;
	
	@Autowired
	private MLocoStoreAuxilaryRepository obj_repoaxo;
	
	@Autowired
	private  MLocoTractionMotorRepository obj_repo;
	
	@Autowired
	private  MLocoBoggieRepository	obj_boogierepo;
	
	
	
	//get control type
	 Logger logger=LoggerFactory.getLogger(LocoDataFois.class);
		@Autowired
		private JdbcTemplate jdbcTemplate;	
		
		public List<String> getlococtrltype(){
			// TODO Auto-generated method stub
			List<String> lococtrl= new ArrayList<>();
			obj_uncleansedcommonrepo.findctrltype()
			.forEach(lococtrl::add);
			return lococtrl;
		}
//		
//		// get loco-make	
		public List<String> getlocomake() {
			// TODO Auto-generated method stub
			List<String> locomake= new ArrayList<>();
			obj_uncleansedcommonrepo.findlocomake()
			.forEach(locomake::add);
			return locomake;
		}

		//get loconominationtype
		public List<String> getloconomination() {
			// TODO Auto-generated method stub
			List<String> loconomi= new ArrayList<>();
			obj_uncleansedcommonrepo.findnomitype()
			.forEach(loconomi::add);	
			return loconomi;
		}


		
		
		
		//get all loco number according to shedid and locotype
		public List<Integer> getAllLocos(LocoDataFois unlocos) {
			// TODO Auto-generated method stub
			System.out.println("getuncleasedlocos");
			List<Integer> locos= new ArrayList<>();
			String shedid = unlocos.getLoco_Owningshed();
//			String traccode= unlocos.getLoco_Tractioncode();
			System.out.println("service"+shedid);
			obj_uncleansedrepo.getLocono(shedid).forEach(locos::add);
			if(locos.isEmpty()) {
			return  locos ;
		}
		else
			System.out.println("data" +locos);
			return  locos;
		
	
	}

//		status changed - Checked(C)
			public boolean updatestatus(LocoDataFois uncleansed ) {
				try{
				String locostatus= uncleansed.getuStatus();
				int lno=uncleansed.getLoco_No();
				System.out.println(lno);
				obj_uncleansedrepo.updatestatus(lno);				
					return  true ;
				
				}
				catch(Exception e){
					
					System.out.println(e);
					return false;
				}
			}	
		
//		
		
		public List<MLocoType> getlocotypelist()
		{
	   	  return obj_uncleansedtyperepo.getallLocotype();
	}
		
		public List<MLocoShed> getallelctricshedid()
		{
			 List<MLocoShed> shedid = new ArrayList<>();		 
			 obj_shedrepo.findAll().forEach(shedid::add);
			 return shedid;
		}
		
		
		public List<MLocoShed> getalldieselshedid()
		{
			 List<MLocoShed> shedid = new ArrayList<>();		 
			 obj_shedrepo.findDShed().forEach(shedid::add);
			 return shedid;
		}
		
		
		public String getZone(String shedmaster) {
			
			return obj_shedrepo.findzone(shedmaster);
			}

		//get uncleansed data - status ==null
		public List<LocoDataFois> getdata(LocoDataFois unlocos) {
			// TODO Auto-generated method stub
			System.out.println("getuncleasedlocos");
			int locono= unlocos.getLoco_No();
			List<LocoDataFois> locos= new ArrayList<>();
			obj_uncleansedrepo.getallLocodata(locono)
			.forEach(locos::add);		
			if(locos.isEmpty()) {
				return  locos ;
			}
			else
				System.out.println("data" +locos);
				return  locos;
			
		
		}
		
		//get uncleansed tracton code  data - status ==null
				public String gettractioncode(LocoDataFois unlocos) {
					// TODO Auto-generated method stub
					System.out.println("getuncleasedlocos");
					int locono= unlocos.getLoco_No();		
					System.out.println(locono);
				return  obj_uncleansedrepo.getLocoTractioncode(locono);		
//											return  tc;
					
				
				}
		
		//get uncleansed data as per  locotype 
		public List<MLocoType> getAllLocotypedata(MLocoType unlocotype) {
			// TODO Auto-generated method stub
			System.out.println("getuncleasedlocotype");
			String locotyped=((MLocoType) unlocotype).getLoco_Type();	
			System.out.println(locotyped +"getlocotype");		
			List<MLocoType> unlocotypedata= new ArrayList<>();
			obj_uncleansedtyperepo.getallLocotypedata(locotyped)
			.forEach(unlocotypedata::add);
			if(unlocotypedata.isEmpty()){
				return  unlocotypedata;
			}
			else
			return  unlocotypedata;
		
		}
		
		public List<MLocoBrakeType> getbreaktyp() {
			// TODO Auto-generated method stub
			List<MLocoBrakeType> getbreaktype = new ArrayList<>();			
			obj_breaktyperepo.findAll()
			.forEach(getbreaktype::add);
			return getbreaktype;
			
					}
		
		
		//get all auxilary output list
		public List<MLocoStoreAuxilary> getauxilaryoutput()
		{System.out.println("loco_auxilaryoutput received");
		List<MLocoStoreAuxilary> auxioutput = new ArrayList<>();				
		obj_repoaxo.findall()
				.forEach(auxioutput::add);
		 System.out.println(auxioutput);
		 return auxioutput;		
		}
		
		
		public List<MLocoTractionMotor> getAllMotor() {
			List<MLocoTractionMotor> tmp=new ArrayList<>();
			obj_repo.findmotorcode().forEach(tmp::add);
				return tmp;
			}
		
		
		 public List<MLocoBoggie> getboogie() {
				// TODO Auto-generated method stub
				List<MLocoBoggie> getboogies = new ArrayList<>();
				obj_boogierepo.findAll()
				.forEach(getboogies::add);
				return getboogies;				
						}
		 
		 public List<LocoUncleansedDataElectric> getUnapprovedLocos(LocoUncleansedDataElectric obj_unapproved) {
//				// TODO Auto-generated method stub
				System.out.println("getuncleansedunapprovedocos");
				String shedid=obj_unapproved.getElec_locoOwningShed();
				obj_elec.getUnapprovedLoco(shedid);		
				List<LocoUncleansedDataElectric> uncleaseLoco= new ArrayList<>();
				obj_elec.getUnapprovedLoco(shedid)
				.forEach(uncleaseLoco::add);
				System.out.println(" End getuncleansedunapprovedocos");
				return obj_elec.getUnapprovedLoco(shedid);
			}
		 
		 
//			status changed - Approved(A)
			public boolean updatestatus(LocoUncleansedDataElectric unapproved) {
				try{
//				String locostatus= unapproved.getElec_Status();
				String approvedremarks=unapproved.getElec_Remarks();					
				int lno=unapproved.getElec_locoNo();
				System.out.println(lno);
				obj_elec.updatestatus(lno);				
					return  true ;			
				}
				catch(Exception e){
					
					System.out.println(e);
					return false;
				}
		
	}
	
}
