import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-type-contributor-edit',
  templateUrl: './type-contributor-edit.component.html',
  styleUrls: ['./type-contributor-edit.component.css']
})
export class TypeContributorEditComponent implements OnInit {
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
