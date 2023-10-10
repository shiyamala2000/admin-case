import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { DocumentModel } from '../document-model';

@Component({
  selector: 'app-search-document',
  templateUrl: './search-document.component.html',
  styleUrls: ['./search-document.component.css']
})
export class SearchDocumentComponent implements OnInit{
  isSubMenuOpen = false;

  toggleSubMenu() {
    this.isSubMenuOpen = !this.isSubMenuOpen;
  }

  // API data
  documents: DocumentModel[] = [];

  constructor(private http: HttpClient) {}
  private apiUrl = 'http://localhost:8080/admin';
  searchedDocuments: DocumentModel[] = [];
  
  ngOnInit(): void {
    this.getAllDocuments();
    this.fetchDataFromApi();
  }
  getAllDocuments() {
    this.http.get<DocumentModel[]>(`${this.apiUrl}/fetchAll`).subscribe(
      (response) => {
        this.documents = response;
        console.log('All documents:', response);
      },
    );
  }
  
  
  // Form input properties
  docId: string = '';
  processId: string = '';
  subProcessId: string = '';

  searchDocuments() {
    const queryParams = {
      docId: this.docId,
      processId: this.processId,
      subProcessId: this.subProcessId
    };
    console.log('search html:',queryParams);
    this.http.post<DocumentModel[]>(`${this.apiUrl}/search`, queryParams).subscribe(
      (response) => {
        console.log('API Response:', response);
        this.searchedDocuments = response;
  
        console.log('Search results:', this.searchedDocuments);
      },
    );
  }

  resetForm() {
    // Clear form inputs and reload all documents
    this.docId = '';
    this.processId = '';
    this.subProcessId = '';
    this.getAllDocuments();
  }

  availableOptions: any = {};

  availableProcesses: any[] = [];
  availableSubProcesses: any[] = [];
  availableDocuments: string[] = [];

  fetchDataFromApi() {
    this.http.get<any>(`${this.apiUrl}/searchTabDropDownMenu`).subscribe(
      (response) => {
        this.availableOptions = response;
        this.initializeAvailableOptions();
        console.log('API data:', response);
      },
    );
  }

  initializeAvailableOptions() {
    console.log(":::keys::>>>", Object.keys(this.availableOptions));
    console.log(":::values::>>>", Object.values(this.availableOptions)[1]);
    const objectWithinArray = Object.values(this.availableOptions);
    const key = Object.keys(objectWithinArray)[1];
    console.log(key);
    const chk= Object.values(this.availableOptions).forEach(data=>{
      console.log("::::Dta111:::>>",data);
    })
    this.availableProcesses = Object.keys(this.availableOptions).map(name => ({ name }));
    // this.availableProcessesValue=Object.values(this.availableOptions).forEach({})
  }
  onProcessChange() {
    this.subProcessId = '';
    this.docId = '';

    const selectedProcess = this.availableOptions[this.processId];{}
    if (selectedProcess) {
      console.log("process before if ",selectedProcess);
      console.log("process before if value ",Object.values(selectedProcess));
      console.log("process before if ",Object.keys(selectedProcess));
      this.availableSubProcesses = Object.keys((selectedProcess[0])[0]);
      console.log("process after if ",selectedProcess);
      console.log("process after if ",this.availableSubProcesses)
    } else {
      this.availableSubProcesses = [];
    }
    // this.availableSubProcesses = this.availableOptions[this.processId] || [];
    // this.subProcessId = ''; 
  }
  
  onSubProcessChange() {
    this.docId = '';
    const selectedSubProcess = this.availableOptions[this.processId][this.subProcessId];
    if (selectedSubProcess) {
      // Populate documents related to the selected sub-process
      this.availableDocuments = selectedSubProcess;
    } else {
      this.availableDocuments = [];
    }
    // const selectedSubProcess = this.availableSubProcesses.find(subProcess => subProcess.name === this.subProcessId);
    // this.availableDocuments = selectedSubProcess ? selectedSubProcess.subProcess : [];
  }
  
}
