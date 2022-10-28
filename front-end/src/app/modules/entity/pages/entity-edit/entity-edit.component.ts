import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-entity-edit',
  templateUrl: './entity-edit.component.html',
  styleUrls: ['./entity-edit.component.css']
})
export class EntityEditComponent implements OnInit {
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