import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";

@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrl: './payments.component.css'
})
export class PaymentsComponent implements OnInit{
  public payments: any;
  public dataSource: any;
  //la liste des attribue que je veux afficher pour un payment
  public displayedColumns = ['id', 'date',"amount",  'type', 'status', 'firstName'];


  @ViewChild(MatPaginator) paginator! : any; // chercher dans la partie html un variable de type  MatPaginator
  @ViewChild(MatSort) sort! : MatSort;
  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.http.get("http://localhost:8080/payments")
      .subscribe({
        next : data => {
          this.payments=data;
          //on va utiliser material table pour affichage
          // c'est pas comme precidament ou on a fait *ngFor
          // c'st pour faciliter le travail
          this.dataSource=new MatTableDataSource(this.payments);
          this.dataSource.paginator=this.paginator;
          this.dataSource.sort = this.sort ;
        },
        error: err => {
          console.log(err);
        }
      })

  }

}
