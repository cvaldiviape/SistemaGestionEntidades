import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-type-document-edit',
  templateUrl: './type-document-edit.component.html',
  styleUrls: ['./type-document-edit.component.css']
})
export class TypeDocumentEditComponent implements OnInit {
  public id!: number;
  
  constructor(
    private _route: ActivatedRoute,
  ) { 
    this._route.params.subscribe((params) => {
			this.id = +params["id"];
		});
  }

  ngOnInit(): void {}

}