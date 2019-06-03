export interface IItem {
  id?: number;
  itemno?: number;
  name?: string;
  amount?: number;
  code?: string;
}

export class Item implements IItem {
  constructor(public id?: number, public itemno?: number, public name?: string, public amount?: number, public code?: string) {}
}
