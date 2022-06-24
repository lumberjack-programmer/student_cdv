export class Student {
  // @ts-ignore
  id: number;
  // @ts-ignore
  name: String;
  // @ts-ignore
  email: String;
  // @ts-ignore
  branch: String;


  constructor(name: String, email: String, branch: String) {
    this.name = name;
    this.email = email;
    this.branch = branch;
  }
}
