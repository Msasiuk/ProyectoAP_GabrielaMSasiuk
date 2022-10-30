import { Injectable } from '@angular/core';
import {
  Storage,
  ref,
  uploadBytes,
  list,
  getDownloadURL,
  StorageReference,
} from '@angular/fire/storage';
import { NgModel } from '@angular/forms';

@Injectable({
  providedIn: 'root',
})
export class ImageService {
  url: string = '';

  constructor(private storage: Storage) {}

  public uploadImage($event: any, name: string) {
    const file = $event.target.files[0];
    const imgRef = ref(this.storage, `imagen/` + name);
    uploadBytes(imgRef, file)
      .then((response) => {
        this.getImages(imgRef);
      })
      .catch((error) => console.log(error));
  }

  getImages(imgRef: StorageReference) {
    const imagesRef = ref(this.storage, 'imagen');
    list(imagesRef)
      .then(async (response) => {
        for (let item of response.items) {
          this.url = await getDownloadURL(imgRef);
          console.log('La URL es: ' + this.url);
        }
      })
      .catch((error) => console.log(error));
  }
}
