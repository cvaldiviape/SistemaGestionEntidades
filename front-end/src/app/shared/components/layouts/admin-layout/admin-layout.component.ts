import { Component, OnInit, HostListener  } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { JwtService } from '../../../../security/services/jwt.service';
import { Item } from '../../../../models/others/item';

@Component({
  selector: 'app-admin-layout',
  templateUrl: './admin-layout.component.html',
  styleUrls: ['./admin-layout.component.css'],
})
export class AdminLayoutComponent implements OnInit {
  public openSidebar: boolean
  public openSubMenu: boolean;
  public username: string;
  public appName: string;
  public items: Item[];
  public isMobileSize: boolean;

  constructor(
    private _activedRoute: ActivatedRoute,
    private _router: Router,
    private _jwtService: JwtService
  ) {
    this.openSidebar = false;
    this.isMobileSize = true;
    this.openSubMenu = false;
    this.username = 'Usuario anónimo';
    this.appName = 'Company';
    this.items = [
      {
        title: 'Entidades',
        iconPrimary: 'business',
        iconSecondary: 'chevron_right',
        path: 'entity',
      },
      {
        title: 'Tipo Contribuyentes',
        iconPrimary: 'card_travel',
        iconSecondary: 'chevron_right',
        path: 'type-contributor',
      },
      {
        title: 'Tipo Documentos',
        iconPrimary: 'contact_page',
        iconSecondary: 'chevron_right',
        path: 'type-document',
      },
    ];
  }

  ngOnInit(): void {
    this.username = this._jwtService.getUsername().toUpperCase();
    this.questionSizeDisplay();
  }

  @HostListener('window:resize', ['$event']) onResize(event: any) {
    this.questionSizeDisplay();
  }

  setOpenSidebar(eventOpenSidebar: boolean): void {
    this.openSidebar = !eventOpenSidebar;
  }

  setClosedSidebarOnlyMobile(): void {
    if(this.isMobileSize){
      this.openSidebar = false;
    }
  }
  
  questionSizeDisplay(): void {
    if (window.innerWidth < 479) {
      this.openSidebar = false;
      this.isMobileSize = true;
      this
    } else if (window.innerWidth < 767) {
      this.openSidebar = false;
      this.isMobileSize = true;
    } else if(window.innerWidth < 991) {
      this.openSidebar = false;
      this.isMobileSize = false;
    } else if(window.innerWidth < 1199) {
      this.openSidebar = false;
      this.isMobileSize = false;
    } else if(window.innerWidth >= 1200){
      this.openSidebar = true;
      this.isMobileSize = false;
    }
  }

}