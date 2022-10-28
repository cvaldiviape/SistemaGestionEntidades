import { Component, Input, OnInit } from '@angular/core';
import { Item } from '../../../../models/others/item';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  @Input() openSidebar: boolean;
  @Input() isMobileSize: boolean;
  @Input() items: Item[];

  constructor() { 
    this.items= [];
    this.openSidebar = false;
    this.isMobileSize = true;
  }

  ngOnInit(): void {}

}