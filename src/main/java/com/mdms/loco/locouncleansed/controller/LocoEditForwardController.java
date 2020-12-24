package com.mdms.loco.locouncleansed.controller;

//All Service Method of Loco : Developer: Ritu on 24.10.2020//

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.mdms.loco.locouncleansed.model.LocoDataFois;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;
import com.mdms.loco.locouncleansed.model.MLocoBoggie;
import com.mdms.loco.locouncleansed.model.MLocoBrakeType;
import com.mdms.loco.locouncleansed.model.MLocoShed;
import com.mdms.loco.locouncleansed.model.MLocoStoreAuxilary;
import com.mdms.loco.locouncleansed.model.MLocoTractionMotor;
import com.mdms.loco.locouncleansed.model.MLocoType;
import com.mdms.loco.locouncleansed.repository.LocoUncleansedDataElectricRepository;
import com.mdms.loco.locouncleansed.repository.MLocoTypeRepository;
import com.mdms.loco.locouncleansed.service.LocoEditForwardService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class LocoEditForwardController {
	Logger logger=LoggerFactory.getLogger(LocoEditForwardController.class);
	
	@Autowired
	 private LocoEditForwardService obj_uncleasedservice;
	
	
	//getloconominationtype
	@RequestMapping(method=RequestMethod.POST, value ="/loconominationtype")
	public List<String> getloconomination() {
		return obj_uncleasedservice.getloconomination();
		
	}//getlococontroltype
	@RequestMapping(method=RequestMethod.POST, value ="/lococontroltype")
	public List<String> getlococtrltype() {
		return obj_uncleasedservice.getlococtrltype();
		
	}

	//get all locomake	
	@RequestMapping(method=RequestMethod.POST, value ="/locomake")
	public List<String> getlocomake() {
		return obj_uncleasedservice.getlocomake();		
	}

	//get uncleansed locono  according to shedbased 
		 @RequestMapping(method=RequestMethod.POST, value="/getuncleansedlocono")
			public List<Integer> getloco(@RequestBody LocoDataFois locos){		 
			 System.out.println(locos.getLoco_Owningshed());				
				  obj_uncleasedservice.getAllLocos(locos);
					System.out.println(obj_uncleasedservice.getAllLocos(locos));					
				  return obj_uncleasedservice.getAllLocos(locos);		 	 	
			}
		 
		 
		 //get uncleanesd loco type list	 
		 @RequestMapping(method=RequestMethod.GET, value="/getuncleansedlocotype")
		 public List<MLocoType> getlocotypelist(){
			 obj_uncleasedservice.getlocotypelist();
			 return obj_uncleasedservice.getlocotypelist();
			 
		 }
		 
		
			
			@RequestMapping(method=RequestMethod.POST, value="/getelectricshedid")	
			public List<MLocoShed> getbaseshed(){
			return obj_uncleasedservice.getallelctricshedid();
			}
			
			@RequestMapping(method=RequestMethod.POST, value="/getdieselshedid")	
			public List<MLocoShed> getdbaseshed(){
			return obj_uncleasedservice.getalldieselshedid();
			}
			
			//get uncleansed loco data from  loco master 
			 @RequestMapping(method=RequestMethod.POST, value="/getuncleansedlocodata")
				public List<LocoDataFois> getdata(@RequestBody LocoDataFois locos){		 
				 System.out.println(locos.getLoco_Owningshed());
				 System.out.println(locos.getLoco_Tractioncode());		 
				  obj_uncleasedservice.getdata(locos);
				 	 		return obj_uncleasedservice.getdata(locos); 	 		
					
				}
			 
			 
			//get  Traction Code from  loco master 
			 @RequestMapping(method=RequestMethod.POST, value="/getuncleansedlocotractioncode")
				public String gettractioncode(@RequestBody LocoDataFois locos){		 
				 System.out.println(locos.getLoco_Owningshed());
				 System.out.println(locos.getLoco_Tractioncode());		 
				  obj_uncleasedservice.gettractioncode(locos);
				 	 		return obj_uncleasedservice.gettractioncode(locos); 	 		
					
				}
			 
			//get uncleansed loco data from loco type master
			 @RequestMapping(method=RequestMethod.POST, value="/getuncleansedlocotypedata")
				public List<MLocoType> getlocotypedata(@RequestBody MLocoType unlocotype){		 
				 System.out.println( "controller" + unlocotype.getLoco_Type());
				 	  obj_uncleasedservice.getAllLocotypedata(unlocotype);
						System.out.println(obj_uncleasedservice.getAllLocotypedata(unlocotype));					
					  return obj_uncleasedservice.getAllLocotypedata(unlocotype);		 	 	
				}
			 
			 	
					@RequestMapping(method=RequestMethod.POST, value = "/breaktype")
					public List<MLocoBrakeType> getbreak() {
						return obj_uncleasedservice.getbreaktyp();
					}
					
					//get auxilary output 
					@RequestMapping(method=RequestMethod.POST,value="/getauxilaryoutput")
					public List<MLocoStoreAuxilary> getauxilaryoutput(){		
						return obj_uncleasedservice.getauxilaryoutput();
					}
					
					@RequestMapping(method=RequestMethod.POST, value="/get_tractionmotorcode")
					public List<MLocoTractionMotor> getAllMotor(){
						return obj_uncleasedservice.getAllMotor();
					}
					
					@RequestMapping(method=RequestMethod.POST, value="/getzoneService")
					public String getElectricZones(@RequestParam("zone") String zone) {
						return obj_uncleasedservice.getZone(zone);
				}
					
					@RequestMapping(method=RequestMethod.POST, value = "/boogie")
					public List<MLocoBoggie> getboogie() {
						return obj_uncleasedservice.getboogie();
					}

				//  status updated = cleansed "C"
			        @RequestMapping(method=RequestMethod.POST, value="/markedStatusCinFOIS")
					public boolean updatestatus(@RequestBody LocoDataFois uncleasedo) {
						boolean flag=obj_uncleasedservice.updatestatus(uncleasedo);
							return flag;
					}
					
			        @RequestMapping(method=RequestMethod.POST, value = "/eCleansedUnapprovedLoco")
			    	public List<LocoUncleansedDataElectric> geteUnapprovedLoco(@RequestBody LocoUncleansedDataElectric obj_eunapproved){
			    		System.out.println("shedid"+ obj_eunapproved.getElec_locoOwningShed());
			    		return obj_uncleasedservice.getUnapprovedLocos(obj_eunapproved);
						
			    	}
			    	
			    	//status update U to A  unapproved table
			    	@RequestMapping(method=RequestMethod.POST, value="/updatestatusApproved")
			    	public boolean updatestatus(@RequestBody LocoUncleansedDataElectric unapproved) {
			    		System.out.println("locono"+unapproved.getElec_locoNo());
			    		System.out.println("status"+unapproved.getElec_Status());
			    		System.out.println("dieselremarks"+unapproved.getElec_Remarks());			    		
			    				boolean flag=obj_uncleasedservice.updatestatus(unapproved);
			    					return flag;
			    			}
			    	
}
