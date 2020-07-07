export class ImageFile {

    public src: string;
    public file: File;

    constructor($src: string, $file: File) {
        this.src = $src;
        this.file = $file;
    }
  }