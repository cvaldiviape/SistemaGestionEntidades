import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-btn-custom-a',
  templateUrl: './btn-custom-a.component.html',
  styleUrls: ['./btn-custom-a.component.css']
})
export class BtnCustomAComponent implements OnInit {

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
