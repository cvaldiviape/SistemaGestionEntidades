import { COMMA, ENTER, T } from "@angular/cdk/keycodes";
import { Component, Input, ViewChild, ElementRef, SimpleChanges } from "@angular/core";
import { MatChipInputEvent, MatChipList } from "@angular/material/chips";
import { MatAutocompleteSelectedEvent } from "@angular/material/autocomplete";
import { FormControl } from "@angular/forms";
import { Observable } from "rxjs";
import { map, startWith } from 'rxjs/operators';

@Component({
  selector: "app-chip",
  templateUrl: "./chip.component.html",
  styleUrls: ["./chip.component.css"]
})
export class ChipComponent {
  public visible: boolean = true;
  public selectable: boolean = true;
  public removable: boolean = true;
  public addOnBlur: boolean = true;
  public readonly separatorKeysCodes: number[] = [ENTER, COMMA];
  public lengthValue: number = 9;
  @ViewChild("chipList") chipList!: MatChipList;
  @Input() regex: string = "";
  @Input() messageValidation: string = "El valor ingresado no es valido";
  @Input() isRequired = false;
  @Input() messageFieldRequired: string = "Este campo es obligatorio";
  @Input() messageError: string = "";
  @Input() control = new FormControl('');
  @Input() id: string= '';
  @Input() type: string = 'text';
  @Input() placeholder: string = '';
  @Input() required: boolean = false;
  @Input() readonly: boolean = false;
  @Input() maxlength: number = 524288;
  public filteredItems: Observable<string[]>;
  @Input() listItems: string[] = [];
  @Input() itemsForFiltering: string[] = [];
  @ViewChild('valueInput') valueInput!: ElementRef<HTMLInputElement>;

  constructor() {
   this.filteredItems = this.getFilteredItems();
  }

  ngOnChanges(changes: SimpleChanges) {
    this.filteredItems = this.getFilteredItems();
    this.control.setValue(null);
  }

  add(event: MatChipInputEvent): void {
    const value = event.value;
    this.addItem(value);
    event.chipInput!.clear(); // Clear the input value
    this.reset(); 
  }

  addItem(value: string): void {
    if(value.trim().length > 0){
      if(this.regexIsValid()){
        this.addItemWithValidation(value);
      }else{
       this.saveItem(value);
      } 
    }
  }

  addItemWithValidation(value: any): void {
    let rx = new RegExp(this.regex);
    if(rx.test(value)){
      this.saveItem(value);
    }else{
      this.messageError = this.messageValidation;
      this.chipList.errorState = true;
    }
  }

  saveItem(value: any){
    this.listItems.push(value);
    this.messageError = "";
    this.chipList.errorState = false;
  }

  regexIsValid(): boolean {
    return (this.regex==='' || this.regex===null || this.regex === undefined) ? false : true; 
  }

  reset(): void{
    this.valueInput.nativeElement.value = '';
    this.control.setValue(null);
  }

  remove(item: any): void {
    this.removeItem(item, this.listItems);   
    this.verifyFieldRequired();
  }

  removeItem(item: any, list: Array<any>): void{
    const index = list.indexOf(item);
    if (index >= 0) {
      list.splice(index, 1);
    }
  }

  verifyFieldRequired(): void {
    if(this.listItems.length <= 0 && this.isRequired){
      this.messageError = this.messageFieldRequired;
      this.chipList.errorState = true;
    }else{
      this.messageError = "";
      this.chipList.errorState = false;
    }
  }

  selected(event: MatAutocompleteSelectedEvent): void {
    this.listItems.push(event.option.viewValue);
    this.verifyFieldRequired();
    this.reset();
  }

  getFilteredItems(): Observable<string[]> {
    return this.control.valueChanges.pipe(
      startWith(null),
      map((x: string | null) => {
        return x ? this._filter(x) : this.itemsForFiltering.slice()
      }),
    );
  }

  private _filter(value: string): string[] {
    // console.log(this.itemsForFiltering);
    const filterValue = value.toLowerCase();
    return this.itemsForFiltering.filter(x => x.toLowerCase().includes(filterValue));
  }

}