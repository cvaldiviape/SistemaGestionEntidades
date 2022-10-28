import { Component, Input, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-textarea',
  templateUrl: './textarea.component.html',
  styleUrls: ['./textarea.component.css']
})
export class TextareaComponent implements OnInit {
  @Input() id: string= '';
  @Input() control = new FormControl('');
  @Input() type: string = 'text';
  @Input() placeholder: string = '';
  @Input() required: boolean = false;
  @Input() readonly: boolean = false;
  @Input() rows: number = 5;
  @Input() messageErrorRequired: string = 'El campo text area es obligatorio.';
  @Input() messageErrorPattern: string = 'El campo text area es inválido.';

  constructor() { }

  ngOnInit(): void { }

}