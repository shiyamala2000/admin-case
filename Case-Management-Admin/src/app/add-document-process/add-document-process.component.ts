import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MAT_DATE_FORMATS, MatDateFormats } from '@angular/material/core';
import { DocumentModel } from '../document-model';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-document-process',
  templateUrl: './add-document-process.component.html',
  styleUrls: ['./add-document-process.component.css'],
})
export class AddDocumentProcessComponent implements OnInit {
  private apiUrl = 'http://localhost:8080/admin';
  isSubMenuOpen = false;

  toggleSubMenu() {
    this.isSubMenuOpen = !this.isSubMenuOpen;
  }

  constructor(
    private http: HttpClient,
    private toastrService: ToastrService,
    private router:Router
  ) { }

  Bike = false;
  Scooty = false;
  Cycle = false;
  labelPosition: 'before' | 'after' = 'after';
  disabled = false;

  ngOnInit() {
    this.fetchDataFromApi();
  }
  processId: string = '';
  subProcessId: string = '';
  nameOfNewDocument: string = '';

  // Array to store added documents
  addedDocuments: any[] = [];

  addDocumentMethod() {
    const requestData = {
      processId: this.processId,
      subProcessId: this.subProcessId,
      nameOfNewDocument: this.nameOfNewDocument,
    };
    this.http.post<any[]>(`${this.apiUrl}/addNewDocument`, requestData).subscribe({
      next: (response) => {
        this.addedDocuments.push(response);

        // Clear form fields
        this.processId = '';
        this.subProcessId = '';
        this.nameOfNewDocument = '';

        // this.toastrService.success('Success!', 'Document added successfully!');
        const toast = this.toastrService.success('Success!', 'Document added successfully!', {
          timeOut: 10000, // 10 seconds
          closeButton: true, // Show a close button
          progressBar: true, // Show a progress bar
        });

        // Attach a click event handler to the toast
        toast.onTap.subscribe(() => {
          this.goToSearchDocument();
        });
      },
      error: (error) => {
        console.error('Error adding document:', error);
        this.toastrService.warning('Warning!', 'Failed to add document.');
      }
    });
  }
  goToSearchDocument() {
    this.router.navigate(['/searchDocument']);
  }

  availableProcesses: any[] = [];
  availableSubProcesses: any[] = [];

  fetchDataFromApi() {
    this.http.get<any>(`${this.apiUrl}/searchTabDropDownMenu`).subscribe(
      (response) => {
        this.availableProcesses = response;
        console.log('API data:', response);
      },
    );
  }

  selectedProcessType: string = '';

  processTypeChange() {
    this.availableSubProcesses = this.getSubProcesses(this.selectedProcessType);
    // this.Bike = false;
    // this.Scooty = false;
    // this.Cycle = false;
  }
  getSubProcesses(selectedProcess: string): any[] {
    const selectedProcessData = this.availableProcesses.find((process) => process.processName === selectedProcess);
    return selectedProcessData ? selectedProcessData.availableSubProcesses || [] : [];
  }

  resetForm() {
    this.processId = '';
    this.subProcessId = '';
    this.nameOfNewDocument = '';
    this.selectedProcessType = '';
    this.Bike = false;
    this.Scooty = false;
    this.Cycle = false;
  }
}

