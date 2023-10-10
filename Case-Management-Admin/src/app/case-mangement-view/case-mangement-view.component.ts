import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { CaseManagement } from '../case-management';
import { CaseManagementService } from '../case-management.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { GenerateLetterDialogComponent } from '../generate-letter-dialog/generate-letter-dialog.component';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-case-mangement-view',
  templateUrl: './case-mangement-view.component.html',
  styleUrls: ['./case-mangement-view.component.css']
})
export class CaseMangementViewComponent  {
  // private apiUrl = 'http://localhost:8080/admin/searchCaseDocuments';
  private apiUrl = 'http://localhost:8080/nsurecase/';

  caseId: string = '';
  caseData: any[] = [];

  caseManagementVariable: CaseManagement[] = [];
  searchId: string = '';
  filteredData: CaseManagement[] = [];

  constructor(
    private caseManagementService: CaseManagementService,
    private router: Router,
    public dialog: MatDialog,
    private http: HttpClient
  ) { }

  search() {
    this.http.get<any[]>(`${this.apiUrl}?caseId=${this.caseId}`).subscribe({
      next:(response) => {
        this.caseData = response;
      },
      error:(error) => {
        console.error('Error fetching data:', error);
      }
  });
  }
  searchById(): void {
    // this.filteredData = this.caseManagementVariable.filter((caseItem) =>
    //   caseItem.id.toString() === this.searchId
    // );
  }

  openGenerateLetterDialog() {
    // const caseItem = this.caseManagementVariable.find((item) => item.id.toString() === this.searchId && item.status === 'NotReceived');

    // if (caseItem) {
    //   const dialogRef = this.dialog.open(GenerateLetterDialogComponent, {
    //     width: '600px',
    //     data: { id: caseItem.id, documentName: caseItem.documentName },
    //   });

    //   dialogRef.afterClosed().subscribe((result) => {
    //     if (result) {
    //       console.log('Document added:', result);
    //     }
    //   });
    // } else {
    //   console.log('No matching item found for the given ID and status.Because of Status is Received');
    //   const dialogRef = this.dialog.open(GenerateLetterDialogComponent, {
    //     width: '600px',
    //   });

    //   dialogRef.afterClosed().subscribe((result) => {
    //     if (result) {
    //       console.log("open dialog",result);
    //     }
    //   });
    // }
  }
  
  // @ViewChild('fileInput') fileInput!: ElementRef<HTMLInputElement>;

  // onFileSelected(event: Event): void {
  //   const inputElement = event.target as HTMLInputElement;
  //   if (inputElement.files && inputElement.files.length > 0) {
  //     const selectedFile = inputElement.files[0];
  //     console.log('Selected File:', selectedFile);
  //     this.fileInput.nativeElement.value = '';
  //   }
  // }

}
