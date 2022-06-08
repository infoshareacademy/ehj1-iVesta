export interface Driver {
  id: string;
  name: string | undefined;
  lastName: string | undefined;
  phone: number | undefined;
  license: string | undefined;
  availability: boolean | undefined;
}