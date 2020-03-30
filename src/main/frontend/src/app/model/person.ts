
export default class Person {
  private _personId: string;
  private _email: string;
  private _password: string;
  private _firstName: string;
  private _lastName: string;
  private _number: string;
  private _age: number;

  constructor(personId: string, email: string, password: string, firstName: string, lastName: string, number: string, age: number) {
    this._personId = personId;
    this._email = email;
    this._password = password;
    this._firstName = firstName;
    this._lastName = lastName;
    this._number = number;
    this._age = age;
  }


  get personId(): string {
    return this._personId;
  }

  set personId(value: string) {
    this._personId = value;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }

  get password(): string {
    return this._password;
  }

  set password(value: string) {
    this._password = value;
  }

  get firstName(): string {
    return this._firstName;
  }

  set firstName(value: string) {
    this._firstName = value;
  }

  get lastName(): string {
    return this._lastName;
  }

  set lastName(value: string) {
    this._lastName = value;
  }

  get number(): string {
    return this._number;
  }

  set number(value: string) {
    this._number = value;
  }

  get age(): number {
    return this._age;
  }

  set age(value: number) {
    this._age = value;
  }
}


