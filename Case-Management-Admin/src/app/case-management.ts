export class CaseManagement {
    id:number;
    role:String;
    lAProposerName:String;
    documentName:String;
    requestDate:Date;
    medicalAppointmentDate:Date;
    status:String;
    receivedDate:Date;
    firstOrReTestIndicator:String;
    followUp:String;


    constructor(){
        this.id=0;
        this.role='';  
        this.lAProposerName='';
        this.documentName='';
        this.requestDate=new Date();
        this.medicalAppointmentDate=new Date();
        this.status='';
        this.receivedDate=new Date();
        this.firstOrReTestIndicator='';
        this.followUp='';      }
}

// export class CaseManagement {
//     role:String;
//     proposerName:String;
//     documentName:String;
//     docDueDate:String;
//     receivedStatus:String;
//     receivedDate:String;
    


//     constructor(){
//         this.role='';  
//         this.proposerName='';
//         this.documentName='';
//         this.docDueDate='';
//         this.receivedStatus='';
//         this.receivedDate='';
//     }
// }
