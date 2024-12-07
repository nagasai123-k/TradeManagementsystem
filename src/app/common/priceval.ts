import { AbstractControl, ValidationErrors, ValidatorFn } from "@angular/forms";
import { Observable } from "rxjs";
import { of } from "rxjs";

 

export function MinimumPrice(control: AbstractControl):Observable<ValidationErrors>|null {
    const c = control.value;
    
    // console.log(p);
    // if (c < p + (0.12 * p) || c > p - (0.12 * p) ) {
    //     return of({ 'minprice': true ,'requiredValue':  c - (0.12 * c)});
    // }
    // if(c < p + (0.12 * p)){
    //     return of({'minprice':true});
    // }
     return null;
}
// export function MinimumPrice(price: number): ValidatorFn {
 
//     return (control: AbstractControl): Observable<ValidationErrors>|null => {



//         return null;
//     }}