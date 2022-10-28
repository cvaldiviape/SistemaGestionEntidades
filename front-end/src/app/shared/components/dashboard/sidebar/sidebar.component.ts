import { Component, Input, OnInit } from '@angular/core';
import { Item } from '../../../../models/others/item';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  @Input() openSidebar: boolean;
  @Input() isMobileSize: boolean;
  @Input() appName: string;
  @Input() username: string;
  @Input() items: Item[];

  constructor() {
    this.openSidebar = false;
    this.appName = '';
    this.username = '';
    this.items = [];
    this.isMobileSize = true;
   }

  ngOnInit(): void {}

}
