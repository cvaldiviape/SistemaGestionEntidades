import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { JwtService } from '../../../../security/services/jwt.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  @Input() isMobileSize: boolean; 
  @Input() openSidebar: boolean;
  @Output() openSidebarOutPut = new EventEmitter<boolean>();

  constructor(
    private _jwtService: JwtService,
    private _router: Router,
  ) { 
    this.isMobileSize = true;
    this.openSidebar = false;
  }

  ngOnInit(): void {}

  getOpenSidebar(): void {
    this.openSidebarOutPut.emit(this.openSidebar);
  }

  getClosedSidebar(): void {
    // debugger
    if(this.openSidebar && this.isMobileSize){
      this.openSidebarOutPut.emit(this.openSidebar);
    }
  }

  closeSession(): void {
    this._jwtService.logout();
    this._router.navigateByUrl('/auth');
  }

}