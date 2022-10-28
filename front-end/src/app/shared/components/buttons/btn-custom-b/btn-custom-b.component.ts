import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-btn-custom-b',
  templateUrl: './btn-custom-b.component.html',
  styleUrls: ['./btn-custom-b.component.css']
})
export class BtnCustomBComponent implements OnInit {

  @Input() loading: boolean = false;
  @Input() text: string = "button";
  @Input() type: string = "button";
  @Input() disabled: boolean = false;
  @Output() OnClick = new EventEmitter<string>();
  public textLoading: string = "Loading";

  constructor() { }

  ngOnInit(): void {
  }

  emitEvent(): void{
    this.OnClick.emit();
  }
  
}